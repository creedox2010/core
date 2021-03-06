/*
 * Copyright 2011-2012 PrimeFaces Extensions.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * $Id$
 */

package org.primefaces.extensions.util;

import java.util.List;

import javax.faces.context.FacesContext;

import org.primefaces.extensions.component.base.AbstractParameter;

/**
 * Extended {@link org.primefaces.util.AjaxRequestBuilder}.
 *
 * @author Thomas Andraschko / last modified by $Author$
 * @version $Revision$
 * @since 0.5
 */
public class AjaxRequestBuilder extends org.primefaces.util.AjaxRequestBuilder {

	public AjaxRequestBuilder(FacesContext context) {
		super(context);
	}

	public AjaxRequestBuilder params(final String clientId, final List<AbstractParameter> parameters) {
		boolean paramWritten = false;

		for (int i = 0; i < parameters.size(); i++) {
			final AbstractParameter param = parameters.get(i);

			if (paramWritten) {
				buffer.append(",");
			} else {
				paramWritten = true;
				buffer.append(",params:[");
			}

			buffer.append("{name:'");
			buffer.append(clientId).append('_').append(param.getName());
			buffer.append("',value:");
			buffer.append(param.getName());
			buffer.append("}");
		}

		if (paramWritten) {
			buffer.append("]");
		}

		return this;
	}
}
