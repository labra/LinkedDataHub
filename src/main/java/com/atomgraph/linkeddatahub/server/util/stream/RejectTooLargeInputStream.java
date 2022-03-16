/**
 *  Copyright 2020 Martynas Jusevičius <martynas@atomgraph.com>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.atomgraph.linkeddatahub.server.util.stream;

import com.atomgraph.linkeddatahub.server.exception.PayloadTooLargeException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Martynas Jusevičius {@literal <martynas@atomgraph.com>}
 */
public class RejectTooLargeInputStream extends LimitedInputStream
{

    /**
     * Constructs input stream.
     * 
     * @param inputStream original input stream
     * @param pSizeMax maximum payload size in bytes
     */
    public RejectTooLargeInputStream(InputStream inputStream, long pSizeMax)
    {
        super(inputStream, pSizeMax);
    }

    @Override
    protected void raiseError(long pSizeMax, long pCount) throws IOException
    {
        throw new PayloadTooLargeException(pSizeMax, pCount);
    }
    
}
