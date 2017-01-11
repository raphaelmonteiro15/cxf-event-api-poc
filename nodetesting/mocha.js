var assert = require('assert');
describe('Testing array size', function() {
  describe('#getArray()', function() {
    it('Should return 5 as array size', function() {
      var array = getArray();
      assert.equal(5, array.length);
    });
  });
});


class Teste {

  getArray(){
    return [1,2,3,4,5]
  }

}

var array = new Teste()

function functionalTest(){
  let a = [1,2,3,4,5,6,7,8,9]
  a.forEach(a => a + 1)
  return a
}

console.log(array.getArray())
