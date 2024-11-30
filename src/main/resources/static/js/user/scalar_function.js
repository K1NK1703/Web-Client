function loadLongestFactoryValue(url, tableBodyId) {
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Ошибка сети: ' + response.status);
            }
            return response.text();
        })
        .then(data => {
            const tableBody = document.getElementById(tableBodyId);
            tableBody.innerHTML = '';

            const row = document.createElement('tr');
            row.innerHTML = `
                    <td>${data || ''}</td>
                `;
            tableBody.appendChild(row);
        })
        .catch(error => console.error('Ошибка загрузки данных:', error));
}

document.addEventListener('DOMContentLoaded', () => {
    loadLongestFactoryValue('/api/user/sensor/factory/name', 'longestFactoryValueTableBody');
});
