console.log("Script is working!");

// 메뉴 버튼과 사이드바 연결
const menuButton = document.getElementById('menuButton');
const sidebar = document.getElementById('sidebar');

// DOM 요소가 존재하는 경우에만 이벤트 리스너 추가
if (menuButton && sidebar) {
    menuButton.addEventListener('click', () => {
        // 사이드바가 숨겨져 있으면 나타나게 하고, 보이면 숨김
        if (sidebar.style.left === '0px') {
            sidebar.style.left = '-300px';
        } else {
            sidebar.style.left = '0px';
        }
    });
} else {
    console.warn("Menu button or sidebar not found!");
}