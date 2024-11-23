// Load data for Event table
function loadEvents() {
    $.ajax({
        url: '/api/admin/event/events',
        method: 'GET',
        success: function (data) {
            const eventTableBody = $('#eventTableBody');
            eventTableBody.empty();
            data.forEach(event => {
                eventTableBody.append(`
                        <tr>
                            <td>${event.id}</td>
                            <td>${event.time}</td>
                            <td>${event.airQuality}</td>
                            <td>${event.gasEmission}</td>
                            <td>${event.loggingLevel}</td>
                            <td>${event.pressure}</td>
                            <td>${event.temperature}</td>
                            <td>
                                <button class="btn btn-warning btn-sm" onclick="openEditModal(${event.id})">Edit</button>
                                <button class="btn btn-danger btn-sm" onclick="deleteEvent(${event.id})">Delete</button>
                            </td>
                        </tr>
                    `);
            });
        }
    });
}

// Save new event
$('#saveAddEvent').on('click', function () {
    const eventData = {
        time: $('#addTime').val(),
        airQuality: $('#addAirQuality').val(),
        gasEmission: $('#addGasEmission').val(),
        loggingLevel: $('#addLoggingLevel').val(),
        pressure: $('#addPressure').val(),
        temperature: $('#addTemperature').val()
    };

    $.ajax({
        url: '/api/admin/event',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(eventData),
        success: function () {
            $('#addEventModal').modal('hide');
            loadEvents();
        }
    });
});

// Open edit modal
function openEditModal(eventId) {
    $.ajax({
        url: `/api/admin/event/${eventId}`,
        method: 'GET',
        success: function (event) {
            $('#editTime').val(event.time);
            $('#editAirQuality').val(event.airQuality);
            $('#editGasEmission').val(event.gasEmission);
            $('#editLoggingLevel').val(event.loggingLevel);
            $('#editPressure').val(event.pressure);
            $('#editTemperature').val(event.temperature);

            const editModal = new bootstrap.Modal(document.getElementById('editEventModal'));
            editModal.show();

            $('#saveEditEvent').off('click').on('click', function () {
                const updatedEventData = {
                    time: $('#editTime').val(),
                    airQuality: $('#editAirQuality').val(),
                    gasEmission: $('#editGasEmission').val(),
                    loggingLevel: $('#editLoggingLevel').val(),
                    pressure: $('#editPressure').val(),
                    temperature: $('#editTemperature').val()
                };

                $.ajax({
                    url: `/api/admin/event/${eventId}`,
                    method: 'PUT',
                    contentType: 'application/json',
                    data: JSON.stringify(updatedEventData),
                    success: function () {
                        editModal.hide();
                        loadEvents();
                    }
                });
            });
        }
    });
}

// Delete event
function deleteEvent(eventId) {
    if (confirm('Are you sure you want to delete this event?')) {
        $.ajax({
            url: `/api/admin/event/${eventId}`,
            method: 'DELETE',
            success: function () {
                loadEvents();
            }
        });
    }
}

// Initialize table data
$(document).ready(function () {
    loadEvents();
});