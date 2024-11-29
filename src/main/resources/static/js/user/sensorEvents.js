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

            if (!Array.isArray(data)) {
                console.error('Ожидался массив, но получен:', data);
                return;
            }

            data.forEach(item => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${item.factory_name || ''}</td>
                    <td>${item.factory_location || ''}</td>
                    <td>${item.sensor_location || ''}</td>
                    <td>${item.sensor_type || ''}</td>
                    <td>${item.event_time || ''}</td>
                    <td>${item.event_temperature || ''}</td>
                    <td>${item.event_pressure || ''}</td>
                    <td>${item.event_gas_emission || ''}</td>
                    <td>${item.event_air_quality || ''}</td>
                    <td>${item.event_logging_level || ''}</td>
                    <td>${item.zone_level || ''}</td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Ошибка загрузки данных:', error));
}

document.addEventListener('DOMContentLoaded', () => {
    loadDataSensor('/api/user/sensor/sensors', 'sensorsTableBody');
    loadSensorEvents('/api/admin/event/fse', 'sensorEventsTableBody');
});
