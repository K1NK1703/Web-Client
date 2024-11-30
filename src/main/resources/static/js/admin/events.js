function loadDataEvent(url, tableBodyId) {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById(tableBodyId);
            tableBody.innerHTML = '';

            data.forEach(item => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${item.id}</td>
                    <td>${item.time || ''}</td>
                    <td>
                        <button class="btn btn-warning" onclick="openEditEventModal(${item.id})">Edit</button>
                        <button class="btn btn-danger" onclick="deleteEvent(${item.id})">Delete</button>
                    </td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Ошибка загрузки данных:', error));
}

function openAddEventModal() {
    document.getElementById('eventTime').value = '';

    $('#addEventModal').modal('show');
}

function addNewEvent() {
    const newEvent = {
        time: document.getElementById('eventTime').value,
        sensorId: document.getElementById('sensorId').value,
        temperature: parseFloat(document.getElementById('temperature').value) || null,
        pressure: parseFloat(document.getElementById('pressure').value) || null,
        gasEmission: parseFloat(document.getElementById('gasEmission').value) || null,
        airQuality: parseFloat(document.getElementById('airQuality').value) || null,
        loggingLevel: document.getElementById('loggingLevel').value || null,
    };

    fetch('/api/admin/event', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newEvent),
    })
        .then(response => {
            if (response.ok) {
                $('#addEventModal').modal('hide');
                loadDataEvent('/api/admin/event/events', 'eventsTableBody');
            } else {
                alert('Ошибка при добавлении записи');
            }
        })
        .catch(error => console.error('Ошибка добавления:', error));
}

function openEditEventModal(id) {
    fetch(`/api/admin/event?id=${id}`)
        .then(response => response.json())
        .then(event => {
            document.getElementById('editEventId').value = event.id;
            document.getElementById('editEventTime').value = event.time;

            $('#editEventModal').modal('show');
        })
        .catch(error => console.error('Ошибка загрузки данных для редактирования:', error));
}

function editEvent() {
    const updatedEvent = {
        id: document.getElementById('editEventId').value,
        time: document.getElementById('editEventTime').value,
    };

    fetch(`/api/admin/event?id=${updatedEvent.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedEvent),
    })
        .then(response => {
            if (response.ok) {
                $('#editEventModal').modal('hide');
                loadDataEvent('/api/admin/event/events', 'eventsTableBody');
            } else {
                alert('Ошибка при редактировании записи');
            }
        })
        .catch(error => console.error('Ошибка редактирования:', error));
}

function deleteEvent(id) {
    if (confirm('Вы уверены, что хотите удалить эту запись?')) {
        fetch(`/api/admin/event?id=${id}`, { method: 'DELETE' })
            .then(response => {
                if (response.ok) {
                    loadDataEvent('/api/admin/event/events', 'eventsTableBody');
                } else {
                    alert('Ошибка при удалении записи');
                }
            })
            .catch(error => console.error('Ошибка удаления:', error));
    }
}

document.addEventListener('DOMContentLoaded', () => {
    loadDataEvent('/api/admin/event/events', 'eventsTableBody');
});
