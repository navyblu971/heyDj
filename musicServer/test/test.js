var assert = require('assert');
describe('Array', function() {
  describe('#indexOf()', function() {
    it('should return -1 when the value is not present', function() {
      assert.equal([1, 2, 3].indexOf(4), -1);
    });
  });
});


describe('author', function() {
    describe('name', function() {
        var author ="atexide"
      it('should pass if the author is atexide', function() {
        assert.equal(author,"atexide");
      });
    });
  });

