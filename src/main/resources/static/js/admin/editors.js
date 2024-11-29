function loadDataEditor(url, tableBodyId) {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById(tableBodyId);
            tableBody.innerHTML = '';

            data.forEach(item => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${item.id}</td>
                    <td>${item.lastName || ''}</td>
                    <td>${item.firstName || ''}</td>
                    <td>${item.middleName || ''}</td>
                    <td>${item.post || ''}</td>
                    <td>${item.phoneNumber || ''}</td>
                    <td>
                        <button class="btn btn-warning" onclick="openEditEditorModal(${item.id})">Edit</button>
                        <button class="btn btn-danger" onclick="deleteEditor(${item.id})">Delete</button>
                    </td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Ошибка загрузки данных:', error));
}

function openAddEditorModal() {
    document.getElementById('editorLastName').value = '';
    document.getElementById('editorFirstName').value = '';
    document.getElementById('editorMiddleName').value = '';
    document.getElementById('editorPost').value = '';
    document.getElementById('editorPhoneNumber').value = '';

    $('#addEditorModal').modal('show');
}

function addNewEditor() {
    const newEditor = {
        lastName: document.getElementById('editorLastName').value,
        firstName: document.getElementById('editorFirstName').value,
        middleName: document.getElementById('editorMiddleName').value,
        post: document.getElementById('editorPost').value,
        phoneNumber: document.getElementById('editorPhoneNumber').value,
    };

    fetch('/api/admin/editor', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newEditor),
    })
        .then(response => {
            if (response.ok) {
                $('#addEditorModal').modal('hide');
                loadDataEditor('/api/admin/editor/editors', 'editorsTableBody');
            } else {
                alert('Ошибка при добавлении записи');
            }
        })
        .catch(error => console.error('Ошибка добавления:', error));
}

function openEditEditorModal(id) {
    fetch(`/api/admin/editor?id=${id}`)
        .then(response => response.json())
        .then(editor => {
            document.getElementById('editEditorId').value = editor.id;
            document.getElementById('editEditorLastName').value = editor.lastName;
            document.getElementById('editEditorFirstName').value = editor.firstName;
            document.getElementById('editEditorMiddleName').value = editor.middleName;
            document.getElementById('editEditorPost').value = editor.post;
            document.getElementById('editEditorPhoneNumber').value = editor.phoneNumber;

            $('#editEditorModal').modal('show');
        })
        .catch(error => console.error('Ошибка загрузки данных для редактирования:', error));
}

function editEditor() {
    const updatedEditor = {
        id: document.getElementById('editEditorId').value,
        lastName: document.getElementById('editEditorLastName').value,
        firstName: document.getElementById('editEditorFirstName').value,
        middleName: document.getElementById('editEditorMiddleName').value,
        post: document.getElementById('editEditorPost').value,
        phoneNumber: document.getElementById('editEditorPhoneNumber').value,
    };

    fetch(`/api/admin/editor?id=${updatedEditor.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedEditor),
    })
        .then(response => {
            if (response.ok) {
                $('#editEditorModal').modal('hide');
                loadDataEditor('/api/admin/editor/editors', 'editorsTableBody');
            } else {
                alert('Ошибка при редактировании записи');
            }
        })
        .catch(error => console.error('Ошибка редактирования:', error));
}

function deleteEditor(id) {
    if (confirm('Вы уверены, что хотите удалить эту запись?')) {
        fetch(`/api/admin/editor?id=${id}`, { method: 'DELETE' })
            .then(response => {
                if (response.ok) {
                    loadDataEditor('/api/admin/editor/editors', 'editorsTableBody');
                } else {
                    alert('Ошибка при удалении записи');
                }
            })
            .catch(error => console.error('Ошибка удаления:', error));
    }
}

document.addEventListener('DOMContentLoaded', () => {
    loadDataEditor('/api/admin/editor/editors', 'editorsTableBody');
});