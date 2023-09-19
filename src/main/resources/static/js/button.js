function changeButtonText() {
  var button = document.getElementById('myButton');

  // 현재 버튼의 텍스트 확인하여 변경
  if (button.innerHTML === 'Click me') {
    button.innerHTML = 'Button clicked!';
  } else {
    button.innerHTML = 'Click me';
  }
}