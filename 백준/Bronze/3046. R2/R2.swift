import Foundation
let arr = readLine()!.split(separator: " ").map { Int($0)! }
print(2*arr[1]-arr[0])