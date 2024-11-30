function checkUserRole() {
    fetch('/api/user/info')
        .then(response => {
            if (!response.ok) {
                throw new Error('Ошибка при получении данных пользователя');
            }
            return response.json();
        })
        .then(user => {
            const isAdmin = user.roles.map(role => role.name).includes('ROLE_ADMIN');
            const adminTab = document.getElementById('adminTab');
            const adminLink = document.querySelector('a[href="#adminTab"]');

            if (isAdmin) {
                adminTab.classList.add('show', 'active');
                adminLink.classList.add('active');
            } else {
                adminTab.style.display = 'none';
                adminLink.parentElement.style.display = 'none';

                const userTab = document.getElementById('userTab');
                const userLink = document.querySelector('a[href="#userTab"]');

                userTab.classList.add('show', 'active');
                userLink.classList.add('active');
            }
        })
        .catch(error => console.error('Ошибка:', error));
}

document.addEventListener('DOMContentLoaded', () => {
    loadDataEvent('/api/admin/event/events', 'eventsTableBody');
    loadDataSensor('/api/user/sensor/sensors', 'sensorsTableBody');
    checkUserRole();
});