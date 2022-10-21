package base.result;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BootstrapAlgorithmResult<X, Y> {

    private final SimpleAlgorithmResult<X, Y> simpleAlgorithmResult;

    private final List<AdvanceAlgorithmResult<X, Y>> advancedAlgorithmResult;

}
