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

$(document).ready(function() {
    console.log("submit")

    $('#submit').click(function() {
        $.ajax({
            type : 'POST',
            data : {
                text : document.querySelector('input[name="text"]:checked').value,
                root: $("#root").val()
            },
            url : 'Soupify',
            success : function(result) {
                console.log(result);
                $('#response').text(result);
                responsiveVoice.speak(result, "UK English Male", {pitch: 1, onend: stopAnimate});
                animate();
            }
        });
    });
});

var id;

function animate() {
	var elem = $('#shakespeare');
	var closed = true;
	id = setInterval(frame, 100);
	function frame() {
		var src = elem.attr("src");
		var context = src.substring(0, src.length - 11);
		if (closed) {
			elem.attr('src',context+'imgs/s2.png');
			closed = false;
		} else {
			elem.attr('src',context+'imgs/s1.png');
			closed = true;
		}
	}
}

function stopAnimate() {
	var elem = $('#shakespeare');
	clearInterval(id);
	var src = elem.attr("src") + "";
	var context = src.substring(0, src.length - 11);
	elem.attr('src',context+'imgs/s1.png');
}
