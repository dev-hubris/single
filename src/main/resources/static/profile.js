document.addEventListener('DOMContentLoaded', () => {
    const registerButton = document.getElementById('profileButton');
    const userIdField = document.getElementById('userId');
    const passwordField = document.getElementById('password');
    const passwordConfirmField = document.getElementById('passwordConfirm');
    const passwordMatchResult = document.getElementById('passwordMatchResult');

    function validateForm() {
        const password = passwordField.value;
        const passwordConfirm = passwordConfirmField.value;
        const isPasswordMatched = password && passwordConfirm && password === passwordConfirm; // 비어 있지 않고 일치하는지 확인
        const isRequiredFieldsFilled = passwordField.value && passwordConfirmField.value;

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
        registerButton.disabled = !(isPasswordMatched && isRequiredFieldsFilled);
    }

    passwordField.addEventListener('input', validateForm);
    passwordConfirmField.addEventListener('input', validateForm);
});