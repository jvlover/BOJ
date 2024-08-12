use std::io::{stdin, Read};

fn main() {
    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);
    
    let s = input.next().unwrap();
    let k = input.next().unwrap();
    let h = input.next().unwrap();
    
    if s+k+h < 100 {
        let ans = s.min(k).min(h);
        if ans == s {
            print!("Soongsil");
        } else if ans == k {
            print!("Korea");
        } else {
            print!("Hanyang");
        }
    } else {
        print!("OK");
    }
}