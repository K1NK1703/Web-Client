document.addEventListener("DOMContentLoaded", async function header() {
    let html = ``;
    const infoUser = document.querySelector('#header');
    let user = await fetch('/api/user/info');
    let json = await user.json();
    html += `
        <span class="fw-bold">${json.username}</span>
        <span>with roles</span>
        <span>${json.roles.map(role => role.name.replace('ROLE_', '')).join(' ')}</span>
    `;
    infoUser.innerHTML = html;
})
