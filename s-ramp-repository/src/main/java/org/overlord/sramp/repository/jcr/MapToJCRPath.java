/*
 * Copyright 2011 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.overlord.sramp.repository.jcr;

public class MapToJCRPath {

    private static int folderDepth     = 3;
    private static String PATH         = "/artifact/%1$s/";
    /**
     * "/artifact/<fileExtension>/[btree]"
     * 
     * @param uuid - Universally Unique ID
     * @param type - fileType (xsd, xml etc)
     * @return path: "/artifact/<type>/[btree]"
     */
    public static String getArtifactPath(String uuid, String type) {
        return String.format(PATH, type) + bTreePath(uuid, type);
    }
    /**
     *  * "/s-ramp/<fileExtension>/[btree]"
     * 
     * @param artifactFileName
     * @return path: "/s-ramp/<type>/[btree]"
     */
    public static String getDerivedArtifactPath(String path) {
        return path.replace("artifact", "s-ramp");
    }
    
    private static String bTreePath (String uuid, String type) {
        String bTreePath = "";
        for (int i=0; i < folderDepth; i++) {
            bTreePath += uuid.substring(2*i, 2*i+2) + "/";
        }
        bTreePath += uuid.substring(folderDepth * 2);
        return bTreePath;
    }
    
}