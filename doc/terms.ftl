<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE martif PUBLIC "ISO 12200:1999A//DTD MARTIF core (DXFcdV04)//EN" "TBXcdv04.dtd">
<martif type="TBX" xml:lang="en">
    <martifHeader>
        <fileDesc>
            <titleStmt>
                <title>${glossary}</title>
            </titleStmt>
        </fileDesc>
        <encodingDesc>
            <p type="DCSName">SYSTEM &quot;TBXDCSv05b.xml&quot;</p>
        </encodingDesc>
    </martifHeader>
    <text>
        <body>
      		<#list terms as term>
            <termEntry id="kde-i18n-ptbr-${term.id}">
                <descrip type="definition">${term.definition}</descrip>
                <langSet xml:lang="en">
                    <ntig>
                        <termGrp>
                            <term>${term.enTerm}</term>
                        </termGrp>
                    </ntig>
                </langSet>
                <langSet xml:lang="pt_BR">
                    <ntig>
                        <termGrp>
                            <term>${term.ptTerm}</term>
                        </termGrp>
                    </ntig>
                </langSet>
            </termEntry>
	        </#list>
        </body>
    </text>
</martif>
