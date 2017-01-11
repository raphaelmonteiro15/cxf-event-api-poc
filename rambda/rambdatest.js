var R = require('ramda');
var assert = require('assert');

describe('Testing array size', function() {
  describe('#all()', function() {
    it('Should return all elements less than 2', function() {
      assert.ok(all());
    });
  });
});


describe('Testing max value', function() {
  describe('#all()', function() {
    it('Should return max value', function() {
      assert.equal(returnMax([1,2,3,4,5]), 5);
    });
  });
});


function all(){
  var lessThan2 = R.flip(R.lt)(2);
  return R.all(lessThan2)([1,1,1,1,1,1]);
}

function returnMax(list){
  return R.apply(Math.max, list);
}
