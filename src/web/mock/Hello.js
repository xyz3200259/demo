
export default {
  'GET /apis/reap-demo/hello/:name': ({ succ, params }) => {
    succ(`Hello ${params.name}`)
  },
}
