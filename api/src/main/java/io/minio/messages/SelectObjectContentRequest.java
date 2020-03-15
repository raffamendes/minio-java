/*
 * MinIO Java SDK for Amazon S3 Compatible Cloud Storage, (C) 2019 MinIO, Inc.
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

package io.minio.messages;

import com.google.api.client.util.Key;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Helper class to generate Amazon AWS S3 request XML for SelectObjectContentRequest information.
 */
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings(value = "URF_UNREAD_FIELD")
public class SelectObjectContentRequest extends XmlEntity {
  @Key("Expression")
  private String expression;

  @Key("ExpressionType")
  private String expressionType;

  @Key("RequestProgress")
  private RequestProgress requestProgress;

  @Key("InputSerialization")
  private InputSerialization inputSerialization;

  @Key("OutputSerialization")
  private OutputSerialization outputSerialization;

  @Key("ScanRange")
  private ScanRange scanRange;

  /** Constructs new SelectObjectContentRequest object for given parameters. */
  public SelectObjectContentRequest(
      String expression,
      boolean requestProgress,
      InputSerialization is,
      OutputSerialization os,
      Long scanStartRange,
      Long scanEndRange)
      throws XmlPullParserException {
    super();
    this.name = "SelectObjectContentRequest";
    super.namespaceDictionary.set("", "http://s3.amazonaws.com/doc/2006-03-01/");

    this.expression = expression;
    this.expressionType = "SQL";
    if (requestProgress) {
      this.requestProgress = new RequestProgress();
    }
    this.inputSerialization = is;
    this.outputSerialization = os;
    if (scanStartRange != null || scanEndRange != null) {
      this.scanRange = new ScanRange(scanStartRange, scanEndRange);
    }
  }
}