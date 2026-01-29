class RobotHazardAuditor {

    public double CalculateHazardRisk(double armPrecision,
                                      int workerDensity,
                                      String machineryStateInput)
            throws RobotSafetyException {

        validateArmPrecision(armPrecision);
        validateWorkerDensity(workerDensity);

        MachineryState machineryState = parseMachineryState(machineryStateInput);

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineryState.getRiskFactor());
    }

    private void validateArmPrecision(double armPrecision)
            throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    "Error: Arm precision must be 0.0-1.0"
            );
        }
    }

    private void validateWorkerDensity(int workerDensity)
            throws RobotSafetyException {

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    "Error: Worker density must be 1-20"
            );
        }
    }

    private MachineryState parseMachineryState(String input)
            throws RobotSafetyException {

        try {
            return MachineryState.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RobotSafetyException(
                    "Error: Unsupported machinery state"
            );
        }
    }
}
