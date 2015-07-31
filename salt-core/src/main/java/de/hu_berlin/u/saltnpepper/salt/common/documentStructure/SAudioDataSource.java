/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.u.saltnpepper.salt.common.documentStructure;

import org.eclipse.emf.common.util.URI;

public interface SAudioDataSource extends SSequentialDS, Bla {

	/**
	 * Returns a {@link URI} object, which points to a audio file. If no uri was
	 * set null is returned.
	 * 
	 * @return {@link URI} to audio file
	 */
	public URI getSAudioReference();

	/**
	 * Sets a {@link URI} object, which points to a audio file.
	 * 
	 * @param audioRef reference to the audio file
	 */
	public void setSAudioReference(URI audioRef);
} // SAudioDataSource
