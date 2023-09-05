$(document).ready(function() {
	$("#login-tab").click(function(event) {
		event.preventDefault();
		$("#login-form").addClass("show active");
		$("#register-form").removeClass("show active");
	});

	$("#register-tab").click(function(event) {
		event.preventDefault();
		$("#register-form").addClass("show active");
		$("#login-form").removeClass("show active");
	});
});