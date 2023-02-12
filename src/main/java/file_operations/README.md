# Java-Advance

`java.nio is faster than java.io,` 
1. Use Filechannel whenever possible
2. Never use InputStream, is it is slowest of all 
> Below are when buffer size = 1024 * 28 <br/>
Time taken by BufferedReader= 23 <br/>
Time taken by BufferedInputStream= 10 <br/>
Time taken by fileChannel= 3 <br/>
Time taken by InputStream= 7721 <br/>
Time taken by FileReader= 52 <br/>

> Below are when buffer size = 1024 * 8 <br/> 
Time taken by BufferedReader= 20 <br/>
Time taken by BufferedInputStream= 14 <br/>
Time taken by fileChannel= 5 <br/>
Time taken by InputStream= 7843 <br/>
Time taken by FileReader= 51 <br/>