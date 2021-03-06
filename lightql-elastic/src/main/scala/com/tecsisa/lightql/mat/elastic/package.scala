/*
 * Copyright (C) 2016 TECNOLOGIA, SISTEMAS Y APLICACIONES S.L. <http://www.tecsisa.com>
 */
package com.tecsisa.lightql
package mat

import com.sksamuel.elastic4s.searches.SearchDefinition
import com.tecsisa.lightql.ast.Query
import org.elasticsearch.index.query.QueryBuilder

package object elastic {

  def materialize(query: Query)(implicit mat: Materializer[QueryBuilder]): QueryBuilder =
    mat.materialize(query)

  implicit class RichSearchDefinition(sd: SearchDefinition) {
    def query(q: Query)(implicit mat: Materializer[QueryBuilder]): SearchDefinition =
      sd.query2(mat.materialize(q))
  }

}
