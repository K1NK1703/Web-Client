function loadDataType(url, tableBodyId) {
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
                    <td>
                        <button class="btn btn-warning" onclick="openEditTypeModal(${item.id})">Edit</button>
                        <button class="btn btn-danger" onclick="deleteType(${item.id})">Delete</button>
                    </td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Ошибка загрузки данных:', error));
}

function openAddTypeModal() {
    document.getElementById('typeName').value = '';

    $('#addTypeModal').modal('show');
}

function addNewType() {
    const newType = {
        name: document.getElementById('typeName').value,
    };

    fetch('/api/user/type', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newType),
    })
        .then(response => {
            if (response.ok) {
                $('#addTypeModal').modal('hide');
                loadDataType('/api/user/type/types', 'typesTableBody');
            } else {
                alert('Ошибка при добавлении записи');
            }
        })
        .catch(error => console.error('Ошибка добавления:', error));
}

function openEditTypeModal(id) {
    fetch(`/api/user/type?id=${id}`)
        .then(response => response.json())
        .then(type => {
            document.getElementById('editTypeId').value = type.id;
            document.getElementById('editTypeName').value = type.name;

            $('#editTypeModal').modal('show');
        })
        .catch(error => console.error('Ошибка загрузки данных для редактирования:', error));
}

function editType() {
    const updatedType = {
        id: document.getElementById('editTypeId').value,
        name: document.getElementById('editTypeName').value,
    };

    fetch(`/api/user/type?id=${updatedType.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedType),
    })
        .then(response => {
            if (response.ok) {
                $('#editTypeModal').modal('hide');
                loadDataType('/api/user/type/types', 'typesTableBody');
            } else {
                alert('Ошибка при редактировании записи');
            }
        })
        .catch(error => console.error('Ошибка редактирования:', error));
}

function deleteType(id) {
    if (confirm('Вы уверены, что хотите удалить эту запись?')) {
        fetch(`/api/user/type?id=${id}`, { method: 'DELETE' })
            .then(response => {
                if (response.ok) {
                    loadDataType('/api/user/type/types', 'typesTableBody');
                } else {
                    alert('Ошибка при удалении записи');
                }
            })
            .catch(error => console.error('Ошибка удаления:', error));
    }
}

document.addEventListener('DOMContentLoaded', () => {
    loadDataType('/api/user/type/types', 'typesTableBody');
});