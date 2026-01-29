class RobotHazardAuditor {

    public void validateArmPrecision(double armPrecision)
            throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    "Error: Arm precision must be 0.0-1.0"
            );
        }
    }

    public void validateWorkerDensity(int workerDensity)
            throws RobotSafetyException {

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    "Error: Worker density must be 1-20"
            );
        }
    }

    public MachineryState validateMachineryState(String machineryState)
            throws RobotSafetyException {

        try {
            return MachineryState.valueOf(machineryState.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RobotSafetyException(
                    "Error: Unsupported machinery state"
            );
        }
    }

    public double calculateHazardRisk(double armPrecision,
                                      int workerDensity,
                                      MachineryState machineryState) {

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineryState.getRiskFactor());
    }
}
