namespace baekjoon
{
    class Program
    {
        static void Main(string[] args)
        {
            int N = int.Parse(Console.ReadLine());
            int[] arr = Console.ReadLine().Split().Take(N).Select(int.Parse).ToArray();
            double cluster = int.Parse(Console.ReadLine());
            double ans = 0;
            foreach (int i in arr) ans += Math.Ceiling(i/cluster)*cluster;
            Console.WriteLine(ans);
        }
    }
}