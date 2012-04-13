/*
 * Copyright 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.googlecodesamples;

import net.oauth.OAuthAccessor;
import net.oauth.OAuthConsumer;
import net.oauth.OAuthServiceProvider;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpSession;

/**
 * Constructs OAuthAccessor for Fusion Tables API.
 *
 * @author googletables-feedback@google.com (Anno Langen)
 */
public class OAuthConfig {

  /**
   * OAuth scope for Fusion Tables API.
   */
  private static final String SCOPE = "https://www.googleapis.com/auth/fusiontables";

  /**
   * OAuth configuration for Google and Fusion Tables API scope.
   */
  private static final OAuthServiceProvider PROVIDER = new OAuthServiceProvider(
      "https://www.google.com/accounts/OAuthGetRequestToken?scope=" + SCOPE,
      "https://www.google.com/accounts/OAuthAuthorizeToken",
      "https://www.google.com/accounts/OAuthGetAccessToken");

  private static final Properties OAUTH_PROPERTIES = new Properties();

  static {
    try {
      OAUTH_PROPERTIES.load(OAuthConfig.class.getResourceAsStream("oauth.properties"));
    } catch (IOException e) {
      throw new AssertionError(e);
    }
  }

  /**
   * OAuth consumer key. Use your key here or configure your key in top level pom.xml.
   */
  private static final String KEY = OAUTH_PROPERTIES.getProperty("oauth.consumer.key");

  /**
   * OAuth consumer secret. Web masters can register their domains and generate and manage keys for
   * them at https://www.google.com/accounts/ManageDomains. Use your secret here or configure your
   * secret in top level pom.xml.
   */
  private static final String SECRET = OAUTH_PROPERTIES.getProperty("oauth.consumer.secret");

  public static OAuthAccessor getSessionAccessor(HttpSession session) {
    OAuthAccessor accessor = (OAuthAccessor) session.getAttribute("oauthAccessor");
    if (accessor == null) {
      accessor = new OAuthAccessor(new OAuthConsumer(null, KEY, SECRET, PROVIDER));
      session.setAttribute("oauthAccessor", accessor);
    }
    return accessor;
  }
}
