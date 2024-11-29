function loadDataFactory(url, tableBodyId) {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById(tableBodyId);
            tableBody.innerHTML = '';

            data.forEach(item => {
                const row = document.createElement('tr');

                row.innerHTML = `
                    <td>${item.id}</td>
                    <td>${item.name || ''}</td>
                    <td>${item.location || ''}</td>
                    <td>
                        <button class="btn btn-warning" onclick="openEditFactoryModal(${item.id})">Edit</button>
                        <button class="btn btn-danger" onclick="deleteFactory(${item.id})">Delete</button>
                    </td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Ошибка загрузки данных:', error));
}

function openAddFactoryModal() {
    document.getElementById('factoryName').value = '';
    document.getElementById('factoryLocation').value = '';

    $('#addFactoryModal').modal('show');
}

function addNewFactory() {
    const newFactory = {
        name: document.getElementById('factoryName').value,
        location: document.getElementById('factoryLocation').value,
    };

    fetch('/api/user/factory', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newFactory),
    })
        .then(response => {
            if (response.ok) {
                $('#addFactoryModal').modal('hide');
                loadDataFactory('/api/user/factory/factories', 'factoriesTableBody');
            } else {
                alert('Ошибка при добавлении записи');
            }
        })
        .catch(error => console.error('Ошибка добавления:', error));
}

function openEditFactoryModal(id) {
    fetch(`/api/user/factory?id=${id}`)
        .then(response => response.json())
        .then(factory => {
            document.getElementById('editFactoryId').value = factory.id;
            document.getElementById('editFactoryName').value = factory.name;
            document.getElementById('editFactoryLocation').value = factory.location;

            $('#editFactoryModal').modal('show');
        })
        .catch(error => console.error('Ошибка загрузки данных для редактирования:', error));
}

function editFactory() {
    const updatedFactory = {
        id: document.getElementById('editFactoryId').value,
        name: document.getElementById('editFactoryName').value,
        location: document.getElementById('editFactoryLocation').value,
    };

    fetch(`/api/user/factory?id=${updatedFactory.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedFactory),
    })
        .then(response => {
            if (response.ok) {
                $('#editFactoryModal').modal('hide');
                loadDataFactory('/api/user/factory/factories', 'factoriesTableBody');
            } else {
                alert('Ошибка при редактировании записи');
            }
        })
        .catch(error => console.error('Ошибка редактирования:', error));
}

function deleteFactory(id) {
    if (confirm('Вы уверены, что хотите удалить эту запись?')) {
        fetch(`/api/user/factory?id=${id}`, { method: 'DELETE' })
            .then(response => {
                if (response.ok) {
                    loadDataFactory('/api/user/factory/factories', 'factoriesTableBody');
                } else {
                    alert('Ошибка при удалении записи');
                }
            })
            .catch(error => console.error('Ошибка удаления:', error));
    }
}

document.addEventListener('DOMContentLoaded', () => {
    loadDataFactory('/api/user/factory/factories', 'factoriesTableBody');
});