// Introduced in html 5

// local storage is a type of web storage that allows websites to store data in the browser on a user's device. It provides a way to persist data across sessions, meaning that the data remains available even after the browser is closed and reopened. Local storage is typically used for storing small amounts of data, such as user preferences, settings, or temporary information.

// session storage is another type of web storage that allows websites to store data in the browser on a user's device, but it is only available for the duration of the page session. This means that the data is cleared when the user closes the browser or navigates away from the page. Session storage is typically used for storing temporary data that is only needed for the current session, such as form inputs or temporary state information.

// both belongs to particular domain only
// session belong to particular session (current tab only) while local storage is available across all tabs and windows of the same domain. This means that if a user opens multiple tabs or windows of the same website, they will all have access to the same local storage data, but each tab or window will have its own separate session storage data.


localStorage.setItem("name", 1);
localStorage.setItem("age", "20");
sessionStorage.setItem("name", 1);

console.log(localStorage.getItem("name"));
console.log(localStorage.getItem("age"));
// always stored in form of string

// old data storage ways : cookies
// shared accross all the sessions and tabs of the same domain
// limit of 4kb
// cookies are sticky if they are set once then they are attached to every request made to the server until they expire or are deleted. 
// many more configuration options available for cookies like expiration time, domain, path, secure flag, httpOnly flag, sameSite flag etc.
// main purpose of cookie is authetication
