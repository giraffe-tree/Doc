# GraphQL

a query lauguage for your api

## 在线测试

https://graphql.github.io/swapi-graphql/

https://apis.guru/graphql-voyager/

https://github.com/zhuanzhuanfe/articles/issues/2

https://segmentfault.com/a/1190000006132986



## 示例

### 特殊类型

```
schema {
  query: Query
  mutation: Mutation
}
```

### 参数

```
type Starship {
  id: ID!
  name: String!
  length(unit: LengthUnit = METER): Float
}
```

### 使用 `mutation`


```
mutation CreateReviewForEpisode($ep: Episode!, $review: ReviewInput!) {
  createReview(episode: $ep, review: $review) {
    stars
    commentary
  }
}

{
  "ep": "JEDI",
  "review": {
    "stars": 5,
    "commentary": "This is a great movie!"
  }
}
```

### 自省

```
{
    __schema {
      	queryType {
      	  name
      	  description
      	}
      	mutationType {
      	  name
      	  description
      	}
      	directives {
      	  description
      	}
        types {
            name
          interfaces {
            name
            description
          }
          enumValues {
            description
            deprecationReason
          }
        }
    }
}
```

```
{
    __type(name: "Starship") {
        name
        fields {
            name,
            type {
                name,
                kind
            }
        }
    }
}
```


