let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');

for (let i = 1; i <= input[0]; i++) {
    let ans = input[i].substring(0, 1);
    for (let j = 1; j < input[i].length; j++) {
        if (input[i][j] !== input[i][j-1]) ans += input[i][j];
    }
    console.log(ans);
}