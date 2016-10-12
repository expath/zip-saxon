<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:zip="http://expath.org/ns/zip"
                version="2.0">

   <xsl:import href="http://expath.org/ns/zip.xsl"/>

   <xsl:output indent="yes"/>

   <xsl:param name="zip" select="'sample.zip'"/>

   <xsl:template name="main" match="/">
       <entries>
          <list>
             <xsl:copy-of select="zip:entries($zip)"/>
          </list>
          <text>
             <xsl:copy-of select="zip:text-entry($zip, 'file.txt')"/>
          </text>
          <some-xml>
             <xsl:copy-of select="zip:xml-entry($zip, 'hello.xml')"/>
          </some-xml>
          <html>
             <xsl:copy-of select="zip:html-entry($zip, 'dir/index.html')"/>
          </html>
          <binary>
             <xsl:copy-of select="zip:binary-entry($zip, 'expath-icon.png')"/>
          </binary>
       </entries>
   </xsl:template>

</xsl:stylesheet>
