function search() {
    const searchKeyword = document.getElementById('searchInput').value; // 검색어 가져오기

    // 검색 API 호출 (예: 서버에서 데이터 가져오기)
    fetch(`/api/search?keyword=${searchKeyword}`)
        .then(response => response.json())
        .then(data => {
            const resultsDiv = document.querySelector('.search-results');
            resultsDiv.innerHTML = ''; // 기존 결과 삭제

            // 검색 결과를 HTML로 생성하여 추가
            data.forEach(product => {
                const productDiv = document.createElement('div');
                productDiv.classList.add('product');

                const img = document.createElement('img');
                img.src = product.image;
                productDiv.appendChild(img);

                // ... 다른 요소들도 동일하게 생성하여 추가

                resultsDiv.appendChild(productDiv);
            });
        });
}