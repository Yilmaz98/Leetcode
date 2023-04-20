var widthOfBinaryTree = function(root) {
    const nodes = {};
    let maxWidth = 0;

    var findMaxWidth = (root, count, index) => {
        if (!root) return;
        if (!nodes.hasOwnProperty(count))
            nodes[count] = index;

        const idx = index - nodes[count];

        maxWidth = Math.max(maxWidth, idx + 1);

        findMaxWidth(root.left, count + 1, 2 * idx);
        findMaxWidth(root.right, count + 1, 2 * idx + 1);
    };

    findMaxWidth(root, 0, 0);
    return maxWidth;
};