function loadDataSensor(url, tableBodyId) {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById(tableBodyId);
            tableBody.innerHTML = '';

            data.forEach(item => {
                const row = document.createElement('tr');

                row.innerHTML = `
                    <td>${item.id}</td>
                    <td>${item.typeId || ''}</td>
                    <td>${item.location || ''}</td>
                    <td>${item.factoryId || ''}</td>
                    <td>${item.installDate || ''}</td>
                    <td>${item.editorId || ''}</td>
                    <td>${item.eventId || ''}</td>
                    <td>
                        <button class="btn btn-warning" onclick="openEditSensorModal(${item.id})">Edit</button>
                        <button class="btn btn-danger" onclick="deleteSensor(${item.id})">Delete</button>
                    </td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Ошибка загрузки данных:', error));
}

function openAddSensorModal() {
    document.getElementById('sensorTypeId').value = '';
    document.getElementById('sensorLocation').value = '';
    document.getElementById('sensorFactoryId').value = '';
    document.getElementById('sensorInstallDate').value = '';
    document.getElementById('sensorEditorId').value = '';
    document.getElementById('sensorEventId').value = '';

    $('#addSensorModal').modal('show');
}

function addNewSensor() {
    const newSensor = {
        typeId: document.getElementById('sensorTypeId').value,
        location: document.getElementById('sensorLocation').value,
        factoryId: document.getElementById('sensorFactoryId').value,
        installDate: document.getElementById('sensorInstallDate').value,
        editorId: document.getElementById('sensorEditorId').value,
        eventId: document.getElementById('sensorEventId').value,
    };

    fetch('/api/user/sensor', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newSensor),
    })
        .then(response => {
            if (response.ok) {
                $('#addSensorModal').modal('hide');
                loadDataSensor('/api/user/sensor/sensors', 'sensorsTableBody');
            } else {
                alert('Ошибка при добавлении записи');
            }
        })
        .catch(error => console.error('Ошибка добавления:', error));
}

function openEditSensorModal(id) {
    fetch(`/api/user/sensor?id=${id}`)
        .then(response => response.json())
        .then(sensor => {
            document.getElementById('editSensorId').value = sensor.id;
            document.getElementById('editSensorTypeId').value = sensor.typeId;
            document.getElementById('editSensorLocation').value = sensor.location;
            document.getElementById('editSensorFactoryId').value = sensor.factoryId;
            document.getElementById('editSensorInstallDate').value = sensor.installDate;
            document.getElementById('editSensorEditorId').value = sensor.editorId;
            document.getElementById('editSensorEventId').value = sensor.eventId;

            $('#editSensorModal').modal('show');
        })
        .catch(error => console.error('Ошибка загрузки данных для редактирования:', error));
}

function editSensor() {
    const updatedSensor = {
        id: document.getElementById('editSensorId').value,
        typeId: document.getElementById('editSensorTypeId').value,
        location: document.getElementById('editSensorLocation').value,
        factoryId: document.getElementById('editSensorFactoryId').value,
        installDate: document.getElementById('editSensorInstallDate').value,
        editorId: document.getElementById('editSensorEditorId').value,
        eventId: document.getElementById('editSensorEventId').value,
    };

    fetch(`/api/user/sensor?id=${updatedSensor.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedSensor),
    })
        .then(response => {
            if (response.ok) {
                $('#editSensorModal').modal('hide');
                loadDataSensor('/api/user/sensor/sensors', 'sensorsTableBody');
            } else {
                alert('Ошибка при редактировании записи');
            }
        })
        .catch(error => console.error('Ошибка редактирования:', error));
}

function deleteSensor(id) {
    if (confirm('Вы уверены, что хотите удалить эту запись?')) {
        fetch(`/api/user/sensor?id=${id}`, { method: 'DELETE' })
            .then(response => {
                if (response.ok) {
                    loadDataSensor('/api/user/sensor/sensors', 'sensorsTableBody');
                } else {
                    alert('Ошибка при удалении записи');
                }
            })
            .catch(error => console.error('Ошибка удаления:', error));
    }
}

document.addEventListener('DOMContentLoaded', () => {
    loadDataSensor('/api/user/sensor/sensors', 'sensorsTableBody');
});