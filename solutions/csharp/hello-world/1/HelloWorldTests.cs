public class HelloWorldTests
{
    [Fact]
    public void Say_hi()
    {
        Assert.Equal("Goodbye, Mars!", HelloWorld.Hello());
    }
}
