// Проверка ролей пользователя
function checkUserRoles() {
    $.ajax({
        url: '/api/user/roles',
        method: 'GET',
        success: function (roles) {
            if (!roles.includes('ROLE_ADMIN')) {
                // Скрыть вкладку Admin
                $('#admin-tab').parent().hide();
            }
        },
        error: function () {
            console.error('Error fetching user roles.');
        }
    });
}

// Инициализация страницы
$(document).ready(function () {
    checkUserRoles(); // Проверка ролей при загрузке страницы
});