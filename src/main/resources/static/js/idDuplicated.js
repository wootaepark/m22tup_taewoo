function userEmailCheck() {
    const email = document.getElementById("email").value;

    if (email == "") {
        alert("아이디를 입력해주세요!. 필수항목입니다.");
        document.getElementById('username').focus();
        return false;
    }

    fetch(`/userEmailRegister?email=${email}`)
        .then(response => response.json())
        .then(result => {
            if (result.result == "0") {
                if (confirm("이 아이디는 사용 가능합니다. 사용하시겠습니까?")) {
                    usernameOverlapCheck = 1;
                    document.getElementById('email').readOnly = true;
                    document.getElementById('userEmailOverlay').disabled = true;
                    document.getElementById('userEmailOverlay').style.display = "none";
                    document.getElementById('resetEmail').disabled = false;
                    document.getElementById('resetEmail').style.display = "inline-block";
                }
                return false;
            } else if (result.result == "1") {
                alert("이미 사용중인 아이디입니다.");
                document.getElementById('email').focus();
            } else {
                alert("success이지만 result 값이 undefined 잘못됨");
            }
        })
        .catch(error => {
            alert("fetch 실행 실패");
            console.error(error);
        });
}



function nicknameCheck() {
    const nickname = document.getElementById("nickname").value;

    if (nickname == "") {
        alert("닉네임을 입력해주세요!. 필수항목입니다.");
        document.getElementById('nickname').focus();
        return false;
    }

    fetch(`/nicknameRegister?nickname=${nickname}`)
        .then(response => response.json())
        .then(result => {
            if (result.result == "0") {
                if (confirm("이 닉네임은 사용 가능합니다. 사용하시겠습니까?")) {
                    usernameOverlapCheck = 1;
                    document.getElementById('nickname').readOnly = true;
                    document.getElementById('userNicknameOverlay').disabled = true;
                    document.getElementById('userNicknameOverlay').style.display = "none";
                    document.getElementById('resetNickname').disabled = false;
                    document.getElementById('resetNickname').style.display = "inline-block";
                }
                return false;
            } else if (result.result == "1") {
                alert("이미 사용중인 닉네임입니다.");
                document.getElementById('nickname').focus();
            } else {
                alert("success이지만 result 값이 undefined 잘못됨");
            }
        })
        .catch(error => {
            alert("fetch 실행 실패");
            console.error(error);
        });
}

