function loadTopSensors(url, tableBodyId) {
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Ошибка сети: ' + response.status);
            }
            return response.json();
        })
        .then(data => {
            const tableBody = document.getElementById(tableBodyId);
            tableBody.innerHTML = '';

            data.forEach(item => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${item.id || ''}</td>
                    <td>${item.typeId || ''}</td>
                    <td>${item.location || ''}</td>
                    <td>${item.factoryId || ''}</td>
                    <td>${item.installDate || ''}</td>
                    <td>${item.editorId || ''}</td>
                    <td>${item.eventId || ''}</td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Ошибка загрузки данных:', error));
}

document.addEventListener('DOMContentLoaded', () => {
    loadTopSensors('/api/user/sensor/sensors/top', 'topSensorsTableBody');
});
