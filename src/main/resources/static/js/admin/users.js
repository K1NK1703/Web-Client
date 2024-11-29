function loadDataUser(url, tableBodyId) {
    fetch(url)
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById(tableBodyId);
            tableBody.innerHTML = '';

            data.forEach(item => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${item.id}</td>
                    <td>${item.username || ''}</td>
                    <td>${item.roles ? item.roles.replace('ROLE_', '') : ''}</td>
                    <td>
                        <button class="btn btn-warning" onclick="openEditUserModal(${item.id})">Edit</button>
                        <button class="btn btn-danger" onclick="deleteUser(${item.id})">Delete</button>
                    </td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Ошибка загрузки данных:', error));
}

function openAddUserModal() {
    document.getElementById('userUsername').value = '';
    document.getElementById('userPassword').value = '';

    loadRolesIntoSelect('userRoles');

    $('#addUserModal').modal('show');
}

function addNewUser() {
    const newUser = {
        username: document.getElementById('userUsername').value,
        password: document.getElementById('userPassword').value,
        roles: Array.from(document.getElementById('userRoles').selectedOptions).map(option => option.value), // Получаем выбранные роли
    };

    fetch('/api/user', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newUser),
    })
        .then(response => {
            if (response.ok) {
                $('#addUserModal').modal('hide');
                loadDataUser('/api/user/users', 'usersTableBody');
            } else {
                alert('Ошибка при добавлении записи');
            }
        })
        .catch(error => console.error('Ошибка добавления:', error));
}

function openEditUserModal(id) {
    fetch(`/api/user?id=${id}`)
        .then(response => response.json())
        .then(user => {
            document.getElementById('editUserId').value = user.id;
            document.getElementById('editUserUsername').value = user.username;

            loadRolesIntoSelect('editUserRoles', user.roles.map(role => role.id));

            $('#editUserModal').modal('show');
        })
        .catch(error => console.error('Ошибка загрузки данных для редактирования:', error));
}

function editUser() {
    const updatedUser = {
        id: document.getElementById('editUserId').value,
        username: document.getElementById('editUserUsername').value,
        password: document.getElementById('editUserPassword').value,
        roles: Array.from(document.getElementById('editUserRoles').selectedOptions).map(option => option.value), // Получаем выбранные роли
    };

    if (!updatedUser.roles || updatedUser.roles.length === 0) {
        alert('Пожалуйста, выберите хотя бы одну роль.');
        return;
    }

    fetch(`/api/user?id=${updatedUser.id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedUser),
    })
        .then(response => {
            if (response.ok) {
                $('#editUserModal').modal('hide');
                loadDataUser('/api/user/users', 'usersTableBody');
            } else {
                alert('Ошибка при редактировании записи');
            }
        })
        .catch(error => console.error('Ошибка редактирования:', error));
}

function deleteUser(id) {
    if (confirm('Вы уверены, что хотите удалить эту запись?')) {
        fetch(`/api/user?id=${id}`, { method: 'DELETE' })
            .then(response => {
                if (response.ok) {
                    loadDataUser('/api/user/users', 'usersTableBody');
                } else {
                    alert('Ошибка при удалении записи');
                }
            })
            .catch(error => console.error('Ошибка удаления:', error));
    }
}

function loadRolesIntoSelect(selectId, selectedRoleIds = []) {
    fetch('/api/user/roles')
        .then(response => {
            if (!response.ok) {
                throw new Error('Ошибка сети: ' + response.status);
            }
            return response.json();
        })
        .then(roles => {
            const select = document.getElementById(selectId);
            select.innerHTML = '';

            if (Array.isArray(roles) && roles.length > 0) {
                roles.forEach(role => {
                    const roleId = role;
                    const roleName = role.replace('ROLE_', '');

                    const option = document.createElement('option');
                    option.value = roleId;
                    option.textContent = roleName;

                    if (selectedRoleIds.includes(roleId)) {
                        option.selected = true;
                    }

                    select.appendChild(option);
                });
            } else {
                console.warn('Не удалось загрузить роли или роли отсутствуют.');
            }
        })
        .catch(error => console.error('Ошибка загрузки ролей:', error));
}

document.addEventListener('DOMContentLoaded', () => {
    loadDataUser('/api/user/users', 'usersTableBody');
});
