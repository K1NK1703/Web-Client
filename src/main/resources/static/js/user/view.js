function loadSensorEvents(url, tableBodyId) {
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
                    <td>${item.factoryName || ''}</td>
                    <td>${item.factoryLocation || ''}</td>
                    <td>${item.sensorLocation || ''}</td>
                    <td>${item.sensorType || ''}</td>
                    <td>${item.eventTime || ''}</td>
                    <td>${item.eventTemperature || ''}</td>
                    <td>${item.eventPressure || ''}</td>
                    <td>${item.eventGasEmission || ''}</td>
                    <td>${item.eventAirQuality || ''}</td>
                    <td>${item.eventLoggingLevel || ''}</td>
                    <td>${item.zoneLevel || ''}</td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Ошибка загрузки данных:', error));
}

document.addEventListener('DOMContentLoaded', () => {
    loadSensorEvents('/api/user/sensor/events', 'sensorEventsTableBody');
    
    setInterval(() => {
        loadSensorEvents('/api/user/sensor/events', 'sensorEventsTableBody');
    }, 1000)
});
