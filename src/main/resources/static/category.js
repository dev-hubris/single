$(document).ready(function() {
    // 서버에서 상품 데이터 가져오기 (예시)
    $.ajax({
        url: '/api/products',
        success: function(data) {
            window.products = data; // 전역 변수에 저장

            // 카테고리 클릭 이벤트 처리
            $('.category').click(function() {
                const categoryId = $(this).data('category-id');
                const filteredProducts = products.filter(product => product.categoryId === categoryId);

                // 상품 목록 영역 비우고 새로 채우기
                $('#products').empty();

                filteredProducts.forEach(product => {
                    $('#products').append(`
                        <div class="product">
                            <img src="${product.imageUrl}" alt="${product.name}">
                            <h3>${product.name}</h3>
                            <p>${product.price}</p>
                        </div>
                    `);
                });
            });
        }
    });
});