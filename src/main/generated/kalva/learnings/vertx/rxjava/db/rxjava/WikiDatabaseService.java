/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package kalva.learnings.vertx.rxjava.db.rxjava;

import java.util.Map;
import rx.Observable;
import rx.Single;
import io.vertx.core.json.JsonArray;
import java.util.List;
import io.vertx.core.json.JsonObject;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;


@io.vertx.lang.rxjava.RxGen(kalva.learnings.vertx.rxjava.db.WikiDatabaseService.class)
public class WikiDatabaseService {

  @Override
  public String toString() {
    return delegate.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WikiDatabaseService that = (WikiDatabaseService) o;
    return delegate.equals(that.delegate);
  }
  
  @Override
  public int hashCode() {
    return delegate.hashCode();
  }

  public static final io.vertx.lang.rxjava.TypeArg<WikiDatabaseService> __TYPE_ARG = new io.vertx.lang.rxjava.TypeArg<>(
    obj -> new WikiDatabaseService((kalva.learnings.vertx.rxjava.db.WikiDatabaseService) obj),
    WikiDatabaseService::getDelegate
  );

  private final kalva.learnings.vertx.rxjava.db.WikiDatabaseService delegate;
  
  public WikiDatabaseService(kalva.learnings.vertx.rxjava.db.WikiDatabaseService delegate) {
    this.delegate = delegate;
  }

  public kalva.learnings.vertx.rxjava.db.WikiDatabaseService getDelegate() {
    return delegate;
  }

  public WikiDatabaseService fetchAllPages(Handler<AsyncResult<JsonArray>> resultHandler) { 
    delegate.fetchAllPages(resultHandler);
    return this;
  }

  public Single<JsonArray> rxFetchAllPages() { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      fetchAllPages(fut);
    }));
  }

  public WikiDatabaseService fetchPage(String name, Handler<AsyncResult<JsonObject>> resultHandler) { 
    delegate.fetchPage(name, resultHandler);
    return this;
  }

  public Single<JsonObject> rxFetchPage(String name) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      fetchPage(name, fut);
    }));
  }

  public WikiDatabaseService fetchPageById(int id, Handler<AsyncResult<JsonObject>> resultHandler) { 
    delegate.fetchPageById(id, resultHandler);
    return this;
  }

  public Single<JsonObject> rxFetchPageById(int id) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      fetchPageById(id, fut);
    }));
  }

  public WikiDatabaseService createPage(String title, String markdown, Handler<AsyncResult<Void>> resultHandler) { 
    delegate.createPage(title, markdown, resultHandler);
    return this;
  }

  public Single<Void> rxCreatePage(String title, String markdown) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      createPage(title, markdown, fut);
    }));
  }

  public WikiDatabaseService savePage(int id, String markdown, Handler<AsyncResult<Void>> resultHandler) { 
    delegate.savePage(id, markdown, resultHandler);
    return this;
  }

  public Single<Void> rxSavePage(int id, String markdown) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      savePage(id, markdown, fut);
    }));
  }

  public WikiDatabaseService deletePage(int id, Handler<AsyncResult<Void>> resultHandler) { 
    delegate.deletePage(id, resultHandler);
    return this;
  }

  public Single<Void> rxDeletePage(int id) { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      deletePage(id, fut);
    }));
  }

  public WikiDatabaseService fetchAllPagesData(Handler<AsyncResult<List<JsonObject>>> resultHandler) { 
    delegate.fetchAllPagesData(resultHandler);
    return this;
  }

  public Single<List<JsonObject>> rxFetchAllPagesData() { 
    return Single.create(new io.vertx.rx.java.SingleOnSubscribeAdapter<>(fut -> {
      fetchAllPagesData(fut);
    }));
  }


  public static  WikiDatabaseService newInstance(kalva.learnings.vertx.rxjava.db.WikiDatabaseService arg) {
    return arg != null ? new WikiDatabaseService(arg) : null;
  }
}
