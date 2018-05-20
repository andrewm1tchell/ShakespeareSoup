function validateRoot() {
	var root = document.getElementById("root");
	var words = root.value.split(/\s+/);
	var maxWords = 1;
	var numWords = words.length;
	if (numWords > maxWords) {
		document.getElementById("error").innerText = "You can only have one root word";
		document.getElementById("submit").disabled = true;
	} else {
		document.getElementById("error").innerText = "";
		document.getElementById("submit").disabled = false;
	}
}