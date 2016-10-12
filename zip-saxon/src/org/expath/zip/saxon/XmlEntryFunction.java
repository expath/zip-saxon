/****************************************************************************/
/*  File:       XmlEntryFunction.java                                       */
/*  Author:     F. Georges - fgeorges.org                                   */
/*  Date:       2009-08-09                                                  */
/*  Tags:                                                                   */
/*      Copyright (c) 2009 Florent Georges (see end of file.)               */
/* ------------------------------------------------------------------------ */


package org.expath.zip.saxon;

import net.sf.saxon.expr.StaticProperty;
import net.sf.saxon.lib.ExtensionFunctionCall;
import net.sf.saxon.lib.ExtensionFunctionDefinition;
import net.sf.saxon.om.StructuredQName;
import net.sf.saxon.pattern.NodeKindTest;
import net.sf.saxon.type.BuiltInAtomicType;
import net.sf.saxon.type.ItemType;
import net.sf.saxon.value.SequenceType;
import org.expath.zip.ZipConstants;

/**
 * TODO: Doc...
 * 
 *     zip:xml-entry($href  as xs:string,
 *                   $entry as xs:string) as document-node()?
 *     zip:xml-entry($content as xs:base64Binary,
 *                   $entry   as xs:string) as document-node()?
 *
 * @author Florent Georges
 */
public class XmlEntryFunction
        extends ExtensionFunctionDefinition
{
    @Override
    public StructuredQName getFunctionQName()
    {
        final String uri    = ZipConstants.ZIP_NS_URI;
        final String prefix = ZipConstants.ZIP_NS_PREFIX;
        return new StructuredQName(prefix, uri, LOCAL_NAME);
    }

    @Override
    public int getMinimumNumberOfArguments()
    {
        return 2;
    }

    @Override
    public SequenceType[] getArgumentTypes()
    {
        final int      one    = StaticProperty.EXACTLY_ONE;
        final ItemType s_type = BuiltInAtomicType.STRING;
        final ItemType a_type = BuiltInAtomicType.ANY_ATOMIC;
        SequenceType   string = SequenceType.makeSequenceType(s_type, one);
        SequenceType   anyone = SequenceType.makeSequenceType(a_type, one);
        return new SequenceType[]{ anyone, string };
    }

    @Override
    public SequenceType getResultType(SequenceType[] params)
    {
        final int      optional = StaticProperty.ALLOWS_ZERO_OR_ONE;
        final ItemType itype    = NodeKindTest.DOCUMENT;
        return SequenceType.makeSequenceType(itype, optional);
    }

    @Override
    public ExtensionFunctionCall makeCallExpression()
    {
        return new XmlEntryCall();
    }

    private static final String LOCAL_NAME = "xml-entry";
}


/* ------------------------------------------------------------------------ */
/*  DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS COMMENT.               */
/*                                                                          */
/*  The contents of this file are subject to the Mozilla Public License     */
/*  Version 1.0 (the "License"); you may not use this file except in        */
/*  compliance with the License. You may obtain a copy of the License at    */
/*  http://www.mozilla.org/MPL/.                                            */
/*                                                                          */
/*  Software distributed under the License is distributed on an "AS IS"     */
/*  basis, WITHOUT WARRANTY OF ANY KIND, either express or implied.  See    */
/*  the License for the specific language governing rights and limitations  */
/*  under the License.                                                      */
/*                                                                          */
/*  The Original Code is: all this file.                                    */
/*                                                                          */
/*  The Initial Developer of the Original Code is Florent Georges.          */
/*                                                                          */
/*  Contributor(s): none.                                                   */
/* ------------------------------------------------------------------------ */
