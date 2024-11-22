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

// Get all top-level category list items
// const categories = document.querySelectorAll('#sidebar > ul > li');
//
// // Add a click event listener to each category
// categories.forEach(category => {
//     category.addEventListener('click', function (event) {
//         // Prevent the event from bubbling to parent elements
//         event.stopPropagation();
//
//         // Get the subcategory <ul> inside the clicked category
//         const subcategory = category.querySelector('.subcategory');
//
//         // Toggle the display of the subcategory if it exists
//         if (subcategory) {
//             if (subcategory.style.display === 'block') {
//                 subcategory.style.display = 'none';
//             } else {
//                 subcategory.style.display = 'block';
//             }
//         }
//     });
// });

const categoryItems = document.querySelectorAll('li[data-category-id]');

categoryItems.forEach(item => {
    item.addEventListener('click', (e) => {
        // 클릭 이벤트가 부모나 다른 이벤트로 전파되지 않도록 방지
        e.stopPropagation();


        // 하위 카테고리를 찾음
        const subcategoryList = item.querySelector('.subcategory');
        console.log('Subcategory list:', subcategoryList);

        if (subcategoryList) {
            // 클래스 'show'를 토글하여 하위 카테고리를 보이거나 숨김
            subcategoryList.classList.toggle('show');
            console.log('Category items:', categoryItems);
        } else {
            console.warn('Subcategory list not found for item:', item);
        }
    });
});

$(document).ready(function() {
    $('.menu-item').click(function(e) {
        e.preventDefault(); // 링크 이동 방지
        $(this).next('.submenu').slideToggle();
    });
});