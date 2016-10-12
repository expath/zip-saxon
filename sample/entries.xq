import module namespace zip = "http://expath.org/ns/zip";

<entries>
   <list> {
     zip:entries('sample.zip')
   }
   </list>
   <text> {
     zip:text-entry('sample.zip', 'file.txt')
   }
   </text>
   <some-xml> {
     zip:xml-entry('sample.zip', 'hello.xml')
   }
   </some-xml>
   <html> {
     zip:html-entry('sample.zip', 'dir/index.html')
   }
   </html>
   <binary> {
     zip:binary-entry('sample.zip', 'expath-icon.png')
   }
   </binary>
</entries>
