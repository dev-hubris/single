// 필요한 요소 가져오기
const registerButton = document.getElementById('registerButton');
const userIdField = document.getElementById('userId');
const passwordField = document.getElementById('password');
const passwordConfirmField = document.getElementById('passwordConfirm');
const idCheckResult = document.getElementById('checkResult');
const passwordMatchResult = document.getElementById('passwordMatchResult');

// 조건 확인 함수
function validateForm() {
    const password = passwordField.value;
    const passwordConfirm = passwordConfirmField.value;
    const isPasswordMatched = password && passwordConfirm && password === passwordConfirm; // 비어 있지 않고 일치하는지 확인
    const isIdCheckPassed = idCheckResult.innerText === '사용 가능한 아이디입니다.';
    const isRequiredFieldsFilled = userIdField.value && passwordField.value && passwordConfirmField.value;

    // 비밀번호 일치 여부 시각적 효과
    if (password && passwordConfirm) {
        if (isPasswordMatched) {
            passwordMatchResult.innerText = '비밀번호가 일치합니다.';
            passwordMatchResult.style.color = 'green';
        } else {
            passwordMatchResult.innerText = '비밀번호가 일치하지 않습니다.';
            passwordMatchResult.style.color = 'red';
        }
    } else {
        passwordMatchResult.innerText = ''; // 비어 있을 때는 메시지 표시 안 함
    }

    // 회원가입 버튼 활성화 조건
    registerButton.disabled = !(isPasswordMatched && isIdCheckPassed && isRequiredFieldsFilled);
}

// ID 중복 확인 이벤트
document.getElementById('checkDuplicate').addEventListener('click', () => {
    const userId = userIdField.value;

    if (!userId) {
        idCheckResult.innerText = '아이디를 입력해주세요.';
        idCheckResult.style.color = 'red';
        validateForm(); // 회원가입 버튼 상태 업데이트
        return;
    }

    // 중복 확인 요청
    fetch(`/user/check-duplicate?userId=${userId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            if (data.isDuplicate) {
                idCheckResult.innerText = '중복된 아이디입니다.';
                idCheckResult.style.color = 'red';
            } else {
                idCheckResult.innerText = '사용 가능한 아이디입니다.';
                idCheckResult.style.color = 'green';
            }
            validateForm(); // 회원가입 버튼 상태 업데이트
        })
        .catch(error => {
            console.error('Error:', error);
            idCheckResult.innerText = '중복 확인 중 오류가 발생했습니다.';
            idCheckResult.style.color = 'red';
            validateForm(); // 회원가입 버튼 상태 업데이트
        });
});

// 입력 필드 변화 감지
[userIdField, passwordField, passwordConfirmField].forEach(field => {
    field.addEventListener('input', validateForm);
});
