////////////////////////////////////////////////////////////////////////////////
// BlueJ Checkstyle extension:
//    Checks Java source code for adherence to a set of rules.
// Copyright (C) 2003  Rick Giles
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
////////////////////////////////////////////////////////////////////////////////
package com.puppycrawl.tools.checkstyle.checks;

import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;

/**
 * <p>
 * Checks for nonnlinear control flow statements.
 * </p>
 * <p>
 * An example of how to configure the check is:
 * </p>
 * <pre>
 * &lt;module name="NonlinearFlow"/&gt;
 * </pre>
 * @author Rick Giles
 * @author CS4250 Students (MSU Denver)
 * @version 1.1
 */
public abstract class NonlinearFlowCheck
    extends AbstractCheck
{
    /** @see com.puppycrawl.tools.checkstyle.api.AbstractCheck */
    public int[] getDefaultTokens()
    {
        return new int[] {
            TokenTypes.LITERAL_BREAK,
            TokenTypes.LITERAL_CONTINUE,
            TokenTypes.LITERAL_SWITCH,
            };
    }

    /** @see com.puppycrawl.tools.checkstyle.api.AbstractCheck */
    public void visitToken(DetailAST aAST)
    {
        log(aAST.getLineNo(),
            aAST.getColumnNo() + aAST.getText().length() - 1,
            "Nonlinear control flow");
    }
}
