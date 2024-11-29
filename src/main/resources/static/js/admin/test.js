function loadData(url, tableBodyId) {
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
                    <td>${item.airQuality || ''}</td>
                    <td>${item.gasEmission || ''}</td>
                    <td>${item.loggingLevel || ''}</td>
                    <td>${item.pressure || ''}</td>
                    <td>${item.temperature || ''}</td>
                    <td>
                        <button class="btn btn-warning" onclick="openEditModal(${item.id})">Edit</button>
                        <button class="btn btn-danger" onclick="deleteItem(${item.id})">Delete</button>
                    </td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Ошибка загрузки данных:', error));
}

// Функция для открытия модального окна редактирования
function openEditModal(id) {
    fetch(`/api/admin/event/${id}`)
        .then(response => response.json())
        .then(event => {
            document.getElementById('editEventId').value = event.id;
            document.getElementById('editEventTime').value = event.time.slice(0, 16); // Преобразование формата
            document.getElementById('editEventAirQuality').value = event.airQuality;
            document.getElementById('editEventGasEmission').value = event.gasEmission;
            document.getElementById('editEventLoggingLevel').value = event.loggingLevel;
            document.getElementById('editEventPressure').value = event.pressure;
            document.getElementById('editEventTemperature').value = event.temperature;

            $('#editModal').modal('show'); // Открыть модальное окно
        })
        .catch(error => console.error('Ошибка загрузки данных для редактирования:', error));
}

// Функция для редактирования записи
function editEvent() {
    const updatedEvent = {
        id: document.getElementById('editEventId').value,
        time: document.getElementById('editEventTime').value,
        airQuality: parseFloat(document.getElementById('editEventAirQuality').value),
        gasEmission: parseFloat(document.getElementById('editEventGasEmission').value),
        loggingLevel: document.getElementById('editEventLoggingLevel').value,
        pressure: parseFloat(document.getElementById('editEventPressure').value),
        temperature: parseFloat(document.getElementById('editEventTemperature').value),
    };

    fetch(`/api/admin/event/${updatedEvent.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedEvent),
    })
        .then(response => {
            if (response.ok) {
                $('#editModal').modal('hide'); // Закрыть модальное окно
                loadData('/api/admin/event/events', 'eventsTableBody'); // Перезагрузить данные
            } else {
                alert('Ошибка при редактировании записи');
            }
        })
        .catch(error => console.error('Ошибка редактирования:', error));
}

// Функция для удаления записи
function deleteItem(id) {
    if (confirm('Вы уверены, что хотите удалить эту запись?')) {
        fetch(`/api/admin/event/${id}`, { method: 'DELETE' })
            .then(response => {
                if (response.ok) {
                    loadData('/api/admin/event/events', 'eventsTableBody'); // Перезагрузить данные
                } else {
                    alert('Ошибка при удалении записи');
                }
            })
            .catch(error => console.error('Ошибка удаления:', error));
    }
}

// Функция для добавления новой записи
function addNewEvent() {
    const newEvent = {
        time: document.getElementById('eventTime').value,
        airQuality: parseFloat(document.getElementById('eventAirQuality').value),
        gasEmission: parseFloat(document.getElementById('eventGasEmission').value),
        loggingLevel: document.getElementById('eventLoggingLevel').value,
        pressure: parseFloat(document.getElementById('eventPressure').value),
        temperature: parseFloat(document.getElementById('eventTemperature').value),
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
                $('#addEventModal').modal('hide'); // Закрыть модальное окно
                loadData('/api/admin/event/events', 'eventsTableBody'); // Перезагрузить данные
            } else {
                alert('Ошибка при добавлении записи');
            }
        })
        .catch(error => console.error('Ошибка добавления:', error));
}

// Функция для инициализации данных при загрузке страницы
document.addEventListener('DOMContentLoaded', () => {
    loadData('/api/admin/event/events', 'eventsTableBody'); // Загрузить события при загрузке страницы
});
